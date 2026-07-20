
import os
import shutil
import json

# Configuration
trevo_dark = "#0D0D0D"
ios_root = "/Users/dmitry/dev/trevo-vault/ios/PolkadotVault/Resources"
android_res = "/Users/dmitry/dev/trevo-vault/android/src/main/res"

# 1. Update Welcome Logo (SVG)
logo_svg_path = os.path.join(ios_root, "Assets.xcassets/logo.imageset/logo.svg")
print(f"Updating Welcome Logo at {logo_svg_path}...")

with open(logo_svg_path, 'r') as f:
    content = f.read()

# Replace Polkadot Pink with Trevo Dark
new_content = content.replace("#E6007A", trevo_dark)

with open(logo_svg_path, 'w') as f:
    f.write(new_content)
print("✅ Welcome Logo updated to Trevo Dark.")


# 2. Fix Network Icon
# Source icon from Android
src_icon = os.path.join(android_res, "drawable/network_trevo.png")

# Target image set (renamed to Title Case to match Network Name just in case)
target_imageset_name = "Trevo-Asset-Hub.imageset"
target_imageset_path = os.path.join(ios_root, "ChainIcons.xcassets", target_imageset_name)
target_png_name = "Trevo-Asset-Hub.png"

# Remove old lowercase folder if exists
old_imageset_path = os.path.join(ios_root, "ChainIcons.xcassets/trevo-asset-hub.imageset")
if os.path.exists(old_imageset_path):
    print(f"Removing old imageset: {old_imageset_path}")
    shutil.rmtree(old_imageset_path)

# Create new imageset folder
os.makedirs(target_imageset_path, exist_ok=True)

# Copy icon
dest_icon = os.path.join(target_imageset_path, target_png_name)
print(f"Copying network icon from {src_icon} to {dest_icon}...")
shutil.copy(src_icon, dest_icon)

# Write Contents.json
contents_json = {
  "images" : [
    {
      "filename" : target_png_name,
      "idiom" : "universal"
    }
  ],
  "info" : {
    "author" : "xcode",
    "version" : 1
  }
}

contents_path = os.path.join(target_imageset_path, "Contents.json")
with open(contents_path, 'w') as f:
    json.dump(contents_json, f, indent=2)

print(f"✅ Network Icon setup complete at {target_imageset_path}")
