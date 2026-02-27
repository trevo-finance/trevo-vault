//
//  OnboardingMediator.swift
//  PolkadotVault
//
//  Created by Krzysztof Rodak on 13/03/2023.
//

import Combine
import Foundation
import SwiftUI

// sourcery: AutoMockable
protocol OnboardingMediating: AnyObject {
    var onboardingDone: AnyPublisher<Bool, Never> { get }

    var isUserOnboarded: Bool { get }

    func onboard(verifierRemoved: Bool)
}

final class OnboardingMediator: OnboardingMediating {
    private let navigationInitialisationService: NavigationInitialisationServicing
    private let seedsMediator: SeedsMediating
    private let databaseMediator: DatabaseMediating
    private let onboardingDoneSubject = CurrentValueSubject<Bool, Never>(false)
    var onboardingDone: AnyPublisher<Bool, Never> {
        onboardingDoneSubject.eraseToAnyPublisher()
    }

    var isUserOnboarded: Bool {
        databaseMediator.isDatabaseAvailable()
    }

    init(
        navigationInitialisationService: NavigationInitialisationServicing = NavigationInitialisationService(),
        seedsMediator: SeedsMediating = ServiceLocator.seedsMediator,
        databaseMediator: DatabaseMediating = DatabaseMediator()
    ) {
        self.navigationInitialisationService = navigationInitialisationService
        self.seedsMediator = seedsMediator
        self.databaseMediator = databaseMediator
        // Set initial state based on database availability
        onboardingDoneSubject.send(isUserOnboarded)
    }

    func onboard(verifierRemoved: Bool) {
        print("[OnboardingMediator] onboard() called")
        let removeResult = seedsMediator.removeAllSeeds()
        print("[OnboardingMediator] removeAllSeeds result: \(removeResult)")
        guard removeResult else { return }
        let dbResult = databaseMediator.recreateDatabaseFile()
        print("[OnboardingMediator] recreateDatabaseFile result: \(dbResult)")
        navigationInitialisationService.initialiseNavigation(verifierRemoved: verifierRemoved) { [weak self] result in
            print("[OnboardingMediator] initialiseNavigation completion: \(result)")
            guard let self else {
                print("[OnboardingMediator] self is nil in completion")
                return
            }
            seedsMediator.refreshSeeds()
            print("[OnboardingMediator] sending onboardingDone = true")
            onboardingDoneSubject.send(true)
        }
    }
}
