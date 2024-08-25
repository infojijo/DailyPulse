//
//  AboutListView.swift
//  iosApp
//
//  Created by Remya Abraham on 8/24/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import shared
import SwiftUI

struct AboutListView: View {
  private struct RowItem: Hashable {
    let title: String
    let subtitle: String
  }

  private let items: [RowItem] = {
    let platform = Platform()
    platform.getDeviceDetails()

    var result: [RowItem] = [
      .init(
        title: "Operating System",
        subtitle: "\(platform.osName) \(platform.osVersion)"
      ),
      .init(
        title: "Device",
        subtitle: platform.deviceModel
      ),
      .init(
        title: "Density",
        subtitle: "@\(platform.deviceDensity)x"
      )
    ]
    return result
  }()

  var body: some View {
    List {
      ForEach(items, id: \.self) { item in
        VStack(alignment: .leading) {
          Text(item.title)
            .font(.footnote)
            .foregroundStyle(.secondary)
          Text(item.subtitle)
            .font(.body)
            .foregroundStyle(.primary)
        }
        .padding(.vertical, 4)
      }
    }
  }
}

#Preview {
    AboutListView()
}
