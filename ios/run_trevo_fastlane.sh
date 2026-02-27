#!/bin/bash
# Wrapper to run fastlane-trevo lanes without touching the original fastlane/ config
# Usage: ./run_trevo_fastlane.sh <lane_name> [options]
# Example: ./run_trevo_fastlane.sh register_app
#          ./run_trevo_fastlane.sh setup
#          ./run_trevo_fastlane.sh build_simulator device:'iPhone 15 Pro'

set -e

SCRIPT_DIR="$(cd "$(dirname "$0")" && pwd)"
cd "$SCRIPT_DIR"

if [ -z "$1" ]; then
  echo "Usage: $0 <lane_name> [options]"
  echo ""
  echo "Available lanes:"
  echo "  setup                - Full one-time setup (register + certs + profiles)"
  echo "  register_app         - Register App ID in Developer Portal"
  echo "  certificates         - Fetch/create development certificates"
  echo "  provisioning_profiles - Create provisioning profiles"
  echo "  build_simulator      - Build for iOS Simulator"
  echo "  build_device         - Build for physical device"
  echo "  run_tests            - Run unit tests"
  exit 1
fi

# Swap fastlane dirs
if [ -d "fastlane" ]; then
  mv fastlane fastlane-original
fi
ln -sfn fastlane-trevo fastlane

# Run fastlane, then restore original dir (even if fastlane fails)
cleanup() {
  rm -f fastlane
  if [ -d "fastlane-original" ]; then
    mv fastlane-original fastlane
  fi
}
trap cleanup EXIT

bundle exec fastlane "$@"
