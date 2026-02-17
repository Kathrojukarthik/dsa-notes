import warnings
warnings.filterwarnings("ignore", category=UserWarning)

from PIL import Image
import os

folder = "images"

for file in os.listdir(folder):
    if not file.lower().endswith(".png"):
        continue

    path = os.path.join(folder, file)

    try:
        img = Image.open(path).convert("RGB")
        pixels = img.getdata()

        red_pixels = sum(
            1 for r, g, b in pixels
            if r > 150 and g < 80 and b < 80
        )

        if red_pixels > 100:
            domain = file.replace(".png", "")
            print("\n[+] FOUND RED IMAGE")
            print("[+] File:", file)
            print("[+] Domain: http://" + domain)
            break

    except Exception:
        pass




mkdir images

for i in $(seq 0 255); do
  host="http://0x$(printf '%02x' $i).a.hackycorp.com"
  
  img=$(curl -s "$host" | grep -Eo '<img src="[^"]+"' | cut -d'"' -f2)
  
  if [ ! -z "$img" ]; then
    fullurl="$host/$img"
    echo "Downloading from $host"
    curl -s "$fullurl" -o images/$(printf '%02x' $i).png
  fi
done
