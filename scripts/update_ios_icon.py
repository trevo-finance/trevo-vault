from PIL import Image
import os
import json

# Paths
assets_dir = "/Users/dmitry/dev/trevo-vault/ios/PolkadotVault/Resources/Assets.xcassets/AppIcon.appiconset"
source_file = os.path.join(assets_dir, "appIcon.png")
dest_file = os.path.join(assets_dir, "appIcon_trevo.png")
contents_file = os.path.join(assets_dir, "Contents.json")

print(f"Reading {source_file}...")
img = Image.open(source_path := source_file).convert("RGB")

# Strategy: Use Green channel as mask
# Polkadot Pink is roughly #E6007A (R=230, G=0, B=122)
# White is (255, 255, 255)
# So Green channel moves from 0 (Background) to 255 (Foreground)
# This perfectly captures the anti-aliased edges of the white logo.

r, g, b = img.split()
mask = g 

bg_color = (13, 13, 13)  # #0D0D0D (Trevo Dark)
fg_color = (255, 255, 255) # White

# Create base layers
bg = Image.new("RGB", img.size, bg_color)
fg = Image.new("RGB", img.size, fg_color)

# Composite: Place White Foreground over Dark Background using the Green content as opacity
result = Image.composite(fg, bg, mask)

print(f"Saving new icon to {dest_file}...")
result.save(dest_file)

# Update Contents.json
print("Updating Contents.json...")
with open(contents_file, 'r') as f:
    data = json.load(f)

# Update filename in json
for image in data.get("images", []):
    if image.get("size") == "1024x1024":
        image["filename"] = "appIcon_trevo.png"

with open(contents_file, 'w') as f:
    json.dump(data, f, indent=2)

print("Done! Icon updated.")
