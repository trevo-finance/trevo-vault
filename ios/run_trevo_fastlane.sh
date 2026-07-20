#!/bin/bash
# DEPRECATED. The Trevo fastlane config now lives in ios/fastlane/ (it is the real
# fastlane directory), so the old directory-swap dance is gone. Just run fastlane
# directly. This shim forwards to it so old muscle memory keeps working.
#
#   cd ios && bundle exec fastlane <lane>
#
# See RELEASE.md section 7.
set -e
cd "$(cd "$(dirname "$0")" && pwd)"
echo "note: run_trevo_fastlane.sh is deprecated -- forwarding to 'bundle exec fastlane $*'" >&2
exec bundle exec fastlane "$@"
