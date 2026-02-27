
# Reset version to 1.0.0 (1)

import sys

path = "ios/PolkadotVault.xcodeproj/project.pbxproj"

with open(path, "r") as f:
    lines = f.readlines()

new_lines = []
for line in lines:
    if "MARKETING_VERSION =" in line:
        # Keep indentation
        prefix = line.split("MARKETING_VERSION =")[0]
        new_lines.append(f'{prefix}MARKETING_VERSION = 1.0.0;\n')
    elif "CURRENT_PROJECT_VERSION =" in line:
        prefix = line.split("CURRENT_PROJECT_VERSION =")[0]
        # Skip if already correct? No, force set
        new_lines.append(f'{prefix}CURRENT_PROJECT_VERSION = 1;\n')
    else:
        new_lines.append(line)

with open(path, "w") as f:
    f.writelines(new_lines)

print("Updated project version to 1.0.0 (1)")
