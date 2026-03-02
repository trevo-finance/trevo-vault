//
//  QRCodeImageGenerator.swift
//  Polkadot Vault
//
//  Created by Krzysztof Rodak on 19/10/2022.
//

import QRCode
import SwiftUI
import UIKit

final class QRCodeImageGenerator {
    enum Style {
        case `private`
        case `public`
    }

    private let doc: QRCode.Document

    init() {
        doc = QRCode.Document()
        // TREVO: Raised from .default (Low, ~7%) to .medium (~15%) for better readability
        // with low-resolution cameras (e.g. Mac 720p fixed-focus). See issue #144.
        doc.errorCorrection = .medium
        doc.design.backgroundColor(UIColor.clear.cgColor)
        // TREVO: Changed from Squircle to Square for sharper edges — improves QR detection
        // on cameras with poor focus. Original: QRCode.EyeShape.Squircle()
        doc.design.shape.eye = QRCode.EyeShape.Square()
        doc.design.style.eye = QRCode.FillStyle.Solid(UIColor.black.cgColor)
        // TREVO: Changed from Circle to Square — round dots blur module boundaries
        // at low resolution, making QR unreadable. Original: QRCode.PixelShape.Circle()
        doc.design.shape.onPixels = QRCode.PixelShape.Square()
    }

    func generateQRCode(from bytes: [UInt8], style: QRCodeImageGenerator.Style = .public) -> UIImage {
        style.apply(doc)
        doc.data = Data(bytes)
        return doc.uiImage(CGSize(width: 800, height: 800)) ?? UIImage()
    }
}

extension QRCodeImageGenerator.Style {
    func apply(_ doc: QRCode.Document) {
        switch self {
        case .public:
            doc.design.foregroundColor(UIColor.black.cgColor)
        case .private:
            doc.design.foregroundColor(UIColor(Color(.accentPink500)).cgColor)
        }
    }
}
