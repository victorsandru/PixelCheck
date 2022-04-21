# PixelCheck
## What does it do?
Creates an Image object. An image object consists of a 2d grid of Pixel objects. These Pixel objects location is specified by their respective row and column in the image. The Pixels can also be have "ink" in them. Meaning that you can see the pixel.

In the Object, there can be 'blobs' of ink. The blob object represents where one or more pixels have ink and are immediate neighbours in the image. Immediate neighbours are only pixels that have other pixels either horizontally or vertically and have ink. Diagonals do not apply.

