
import os
import shutil
import json

# Configuration
ios_root = "/Users/dmitry/dev/trevo-vault/ios/PolkadotVault/Resources"
android_res = "/Users/dmitry/dev/trevo-vault/android/src/main/res"

# Source icon from Android
src_icon = os.path.join(android_res, "drawable/network_trevo.png")

# Target image set for DEFAULT LOGO
target_imageset_name = "NetworkLogo-Default.imageset"
target_imageset_path = os.path.join(ios_root, "ChainIcons.xcassets", target_imageset_name)
target_png_name = "NetworkLogo-Default.png"

# Create new imageset folder
os.makedirs(target_imageset_path, exist_ok=True)

# Copy icon
dest_icon = os.path.join(target_imageset_path, target_png_name)
print(f"Copying default network icon from {src_icon} to {dest_icon}...")
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

print(f"✅ Default Network Icon setup complete at {target_imageset_path}")
