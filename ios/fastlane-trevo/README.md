fastlane documentation
----

# Installation

Make sure you have the latest version of the Xcode command line tools installed:

```sh
xcode-select --install
```

For _fastlane_ installation instructions, see [Installing _fastlane_](https://docs.fastlane.tools/#installing-fastlane)

# Available Actions

## iOS

### ios certificates

```sh
[bundle exec] fastlane ios certificates
```

Fetch or create certificates

Usage: fastlane certificates

Fetch or create certificates (Development & Distribution)

Usage: fastlane certificates

### ios register_app

```sh
[bundle exec] fastlane ios register_app
```

Register App ID in Apple Developer Portal and App Store Connect (one-time)

Usage: fastlane register_app

### ios provisioning_profiles

```sh
[bundle exec] fastlane ios provisioning_profiles
```

Create/fetch provisioning profiles (Development & AppStore)

Usage: fastlane provisioning_profiles

### ios setup

```sh
[bundle exec] fastlane ios setup
```

Full setup: register app + certificates + provisioning (Dev & Prod)

Usage: fastlane setup

### ios build_simulator

```sh
[bundle exec] fastlane ios build_simulator
```

Build debug for iOS Simulator (no code signing required)

Usage: fastlane build_simulator [device:'iPhone 16']

### ios build_device

```sh
[bundle exec] fastlane ios build_device
```

Build debug for physical device using Xcode automatic signing

Usage: fastlane build_device

### ios distribute_testflight

```sh
[bundle exec] fastlane ios distribute_testflight
```

Build and upload to TestFlight

Usage: fastlane distribute_testflight

### ios unit_tests

```sh
[bundle exec] fastlane ios unit_tests
```

Run unit tests on simulator

Usage: fastlane unit_tests [device:'iPhone 16']

----

This README.md is auto-generated and will be re-generated every time [_fastlane_](https://fastlane.tools) is run.

More information about _fastlane_ can be found on [fastlane.tools](https://fastlane.tools).

The documentation of _fastlane_ can be found on [docs.fastlane.tools](https://docs.fastlane.tools).
