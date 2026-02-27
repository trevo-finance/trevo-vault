# Trevo Vault: Branch Context (`trevo` vs `trevo-ios`)

Last updated: 2026-02-13
Repository: `/Users/dmitry/dev/trevo-vault`

## 1) Scope

This document summarizes:
- what was done in `trevo-ios`,
- whether those changes are already present in `trevo`,
- how far `trevo-ios` is behind `trevo`,
- and what naming state is expected in Xcode.

It is intended as structured context for another AI/engineer, not a chat transcript.

## 2) Branch state and divergence

Checked after `git fetch origin --prune`.

- Local and remote branch parity:
  - `trevo` vs `origin/trevo`: `0 0`
  - `trevo-ios` vs `origin/trevo-ios`: `0 0`
- Divergence:
  - `trevo...trevo-ios` -> `28 0`
  - Meaning: `trevo` is ahead by 28 commits, `trevo-ios` has no unique commits.
- Ancestry checks:
  - `trevo-ios` is an ancestor of `trevo` (fully merged into `trevo`).
  - `trevo` is NOT an ancestor of `trevo-ios`.

Key tips:
- `trevo` head at analysis time: `159d943b` (2025-12-26)
- `trevo-ios` head at analysis time: `d0cc32a3` (2025-12-25)

## 3) What was done in `trevo-ios`

From the common base `8c7c559d` (`trait/master`) to `trevo-ios` head (`d0cc32a3`), there are 16 commits.

Notable commit list:
- `fb6044c5` (2024-12-01) Android appId/name/icon/version updates
- `8a44bbd7` (2024-12-12) trait-chains fixup
- `178bf887` (2024-12-12) metadata scripts
- `c8156525` (2024-12-17) preselected keys / verifier public key changes
- `368dcce8` (2024-12-17) release 1.0.0
- `f64f79f1` (2024-12-17) QR code script
- `6d854208` (2025-02-06) QR for v1002
- `87589869` (2025-06-09) TRAIT -> Trevo rebrand across project
- `754fe894` (2025-07-29) version + env + QR/docs updates
- `675b9d82` (2025-07-29) README + metadata/docs updates
- `e6a63d97` (2025-07-30) metadata item `1004`
- `5d7c0c20` (2025-08-13) dependency/config bumps
- `bd2a4792` (2025-08-22) iOS rename/rebrand commit (key iOS commit)
- `5fb9a2c8` (2025-12-09) metadata v1009
- `de8544c4` (2025-12-10) metadata v1010
- `d0cc32a3` (2025-12-25) skip airgap checks in debug builds

### 3.1 Key iOS commit

`bd2a4792` (`feat: Rename iOS app from Polkadot Vault to Trevo Vault`)

- Short stat: 34 files changed, 5859 insertions, 212 deletions.
- Includes iOS-side rebrand artifacts:
  - `ios/PolkadotVault/Info.plist`
  - `ios/PolkadotVault/Configuration/Debug.xcconfig`
  - `ios/PolkadotVault/Configuration/QA.xcconfig`
  - `ios/PolkadotVault/Configuration/Production.xcconfig`
  - `ios/PolkadotVault/Resources/en.lproj/Localizable.strings`
  - `ios/PolkadotVault/Resources/Docs/privacy-policy.txt`
  - `ios/PolkadotVault/Resources/Docs/terms-and-conditions.txt`
  - color assets in `ios/PolkadotVault/Resources/Assets.xcassets/...`
  - Trevo network icon asset in `ios/PolkadotVault/Resources/ChainIcons.xcassets/trevo-asset-hub.imageset/...`
  - fastlane and project/scheme updates.

## 4) Was iOS work merged into `trevo`?

Yes.

Evidence:
- `git branch --contains bd2a4792` includes both `trevo-ios` and `trevo`.
- `git branch --contains d0cc32a3` includes both `trevo-ios` and `trevo`.
- Therefore, `trevo` contains the full history of `trevo-ios` up to its head.

## 5) Is `trevo` ahead on iOS after absorbing `trevo-ios`?

Yes.

`git diff --name-only trevo-ios..trevo -- ios` shows 26 iOS files changed after `trevo-ios` head.

Short stat for iOS-only delta:
- 26 files changed, 311 insertions, 133 deletions.

So `trevo` is not only inclusive of `trevo-ios`; it has additional iOS changes beyond it.

## 6) Clarification about app naming in Xcode

Current expected state in `trevo`:

- User-facing app name is rebranded to Trevo:
  - `ios/PolkadotVault/Info.plist`
    - `CFBundleDisplayName = Trevo Vault`
    - `CFBundleName = Trevo Vault`
  - `ios/PolkadotVault/Configuration/Production.xcconfig`
    - `PRODUCT_NAME = Trevo Vault`
  - `ios/PolkadotVault/Configuration/Debug.xcconfig`
    - `PRODUCT_NAME = Trevo Vault Dev`
  - `ios/PolkadotVault/Configuration/QA.xcconfig`
    - `PRODUCT_NAME = Trevo Vault QA`

- Internal technical names remain `PolkadotVault`:
  - Xcode project/target/module names in `ios/PolkadotVault.xcodeproj/project.pbxproj`
  - folder/module identifiers such as `PRODUCT_MODULE_NAME = PolkadotVault`

Conclusion: seeing `PolkadotVault` in Xcode navigator/target identifiers is currently normal and does not mean user-facing naming is wrong.

## 7) Important caveat from project docs

`docs/ios_trevo_mapping.md` states:
- App icons for Trevo were not available in repo and remained unchanged.

So “all Android customizations were mirrored to iOS” is almost true, but not 100% (app icons caveat).

## 8) Practical conclusion

- `trevo-ios` can be treated as historical/integration branch.
- `trevo` is the authoritative branch and already includes `trevo-ios` work.
- For new iOS work, continue from `trevo`.
- If desired, a separate controlled refactor can rename internal Xcode project/target/module identifiers from `PolkadotVault` to `TrevoVault`.

## 9) Reproduction commands

```bash
git fetch origin --prune
git rev-list --left-right --count trevo...trevo-ios
git merge-base --is-ancestor trevo-ios trevo && echo "trevo-ios merged into trevo"
git log --reverse --pretty=format:'%h %ad %s' --date=short 8c7c559d..trevo-ios
git show --shortstat --name-status --format='COMMIT %h%nDATE %ad%nSUBJECT %s%n' --date=short bd2a4792
git diff --shortstat trevo-ios..trevo -- ios
rg -n "CFBundleDisplayName|CFBundleName|PRODUCT_NAME|PRODUCT_MODULE_NAME|PolkadotVault|Trevo Vault" \
  ios/PolkadotVault/Info.plist \
  ios/PolkadotVault/Configuration/*.xcconfig \
  ios/PolkadotVault.xcodeproj/project.pbxproj
```
