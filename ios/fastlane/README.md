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

### ios build_simulator

```sh
[bundle exec] fastlane ios build_simulator
```

Build debug for iOS Simulator (no code signing required)

Usage: fastlane build_simulator [device:'iPhone 15']

### ios build_device

```sh
[bundle exec] fastlane ios build_device
```

Build debug for physical device using Xcode automatic signing

Usage: fastlane build_device

### ios run_tests

```sh
[bundle exec] fastlane ios run_tests
```

Run unit tests on simulator

Usage: fastlane run_tests [device:'iPhone 16']

### ios register_app

```sh
[bundle exec] fastlane ios register_app
```

Register App ID in Apple Developer Portal (one-time)

Usage: fastlane register_app

----

This README.md is auto-generated and will be re-generated every time [_fastlane_](https://fastlane.tools) is run.

More information about _fastlane_ can be found on [fastlane.tools](https://fastlane.tools).

The documentation of _fastlane_ can be found on [docs.fastlane.tools](https://docs.fastlane.tools).
