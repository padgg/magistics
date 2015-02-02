![logo](http://i1064.photobucket.com/albums/u370/MegaT145/Magistics/magistics_banner.png)
***

**_Adding some logistics to Thaumcraft!_**

[![Codeship Status for T145/magistics](https://codeship.com/projects/49546e30-64a5-0132-1a9a-1a1c11ba4c94/status?branch=master)](https://codeship.com/projects/52617)

## Workspace Setup
Once your deobfuscated copy of Thaumcraft is placed into the lib directory, then run one of the scripts contained in the [exec](https://github.com/T145/magistics/tree/master/exec) directory from the project's root directory and you should be all set!

## License Stuff
All of the wonderful license information is located in the project's license file. The project source code falls under this license. *As for the assets (images and such), they are outlined as separate content!* The original creators own them, and require their explicit permission for external usage. Please relay this message through me so I may be in the loop.

## Contributing
1. Fork it
2. Add or remove some stuff
3. Commit your changes (`git commit -am "My awesome change!"`)
4. Create a new pull request!

### Parameters

#### Proper format
The main thing that I ask when making a new pull request is that none of the project's general formatting be affected. This is so that other formats do not conflict w/ what is existing, and avoids giant blocks of highlighted code in Git commits. However, it's also because the code has a great appearance. Code isn't meant to just be functional, it's meant to look good too!

#### Public, public, public!
Whenever new variables, classes, etc. are added to code, please be sure that most are public. This is so that Magistics can maintain a modular atmosphere, and other mods can override things w/ ease. In general, I only make things private that serve to help not type as much, e.g. `private static BlockStoneApparatus.Types = types;`.
