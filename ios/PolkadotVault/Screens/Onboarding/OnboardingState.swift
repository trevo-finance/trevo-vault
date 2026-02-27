//
//  OnboardingState.swift
//  Polkadot Vault
//
//  Created by Krzysztof Rodak on 30/01/2023.
//

import Combine
import SwiftUI

enum OnboardingState: Equatable {
    case terms
    case airgap
    case screenshots
    case setUpNetworksIntro
    case setUpNetworksStepOne
    case setUpNetworksStepTwo
}

final class OnboardingStateMachine: ObservableObject {
    @Published var currentState: OnboardingState = .terms
    private let onboardingMediator: OnboardingMediating

    init(
        onboardingMediator: OnboardingMediating = ServiceLocator.onboardingMediator
    ) {
        self.onboardingMediator = onboardingMediator
    }

    @ViewBuilder
    func currentView() -> some View {
        switch currentState {
        case .terms:
            OnboardingAgreementsView(viewModel: .init { self.onAgreementNextTap() })
        case .airgap:
            NoAirgapView(viewModel: .init(mode: .onboarding) { self.onAirgapNextTap() })
        case .screenshots:
            OnboardingScreenshotsView(viewModel: .init { self.onScreenshotNextTap() })
        case .setUpNetworksIntro:
            SetUpNetworksIntroView(
                viewModel: .init(
                    onNextTap: { self.onSetUpNetworksIntroNext() },
                    onSkipTap: { self.finishOnboarding() }
                )
            )
        case .setUpNetworksStepOne:
            SetUpNetworksStepOneView(
                viewModel: .init(
                    onNextTap: { self.onSetUpNetworksStepOne() },
                    onBackTap: { self.onSetUpNetworksStepOneBackTap() }
                )
            )
        case .setUpNetworksStepTwo:
            SetUpNetworksStepTwoView(
                viewModel: .init(
                    onNextTap: { self.finishOnboarding() },
                    onBackTap: { self.onSetUpNetworksStepTwoBackTap() }
                )
            )
        }
    }

    func onOverviewFinishTap() {
        currentState = .terms
    }

    func onAgreementNextTap() {
        currentState = .airgap
    }

    func onAirgapNextTap() {
        currentState = .screenshots
    }

    func onScreenshotNextTap() {
        // Trevo is already the sole default network in the cold release database,
        // so we skip the Set Up Networks screens entirely.
        finishOnboarding()
    }

    func onSetUpNetworksIntroNext() {
        currentState = .setUpNetworksStepOne
    }

    func onSetUpNetworksStepOne() {
        currentState = .setUpNetworksStepTwo
    }

    func onSetUpNetworksStepOneBackTap() {
        currentState = .setUpNetworksIntro
    }

    func onSetUpNetworksStepTwoBackTap() {
        currentState = .setUpNetworksStepOne
    }

    func finishOnboarding() {
        print("[OnboardingStateMachine] finishOnboarding() called")
        onboardingMediator.onboard(verifierRemoved: false)
    }
}
