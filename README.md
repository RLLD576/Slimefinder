# Slimefinder
### Slime chunks clusters finder for all minecraft java versions
[slimefinder-v1.0](https://github.com/RLLD576/slimefinder/releases/download/v1.0/Slimefinder.zip)

#### Modes:

**-h:** Show this message

**-s:** Search per zone

**-o:** Know if a chunk is slimechunk

**-z:** know how many absolute chunks and partial chunks has an afk point

**-m:** Search until a minimum of chunks

**-b:** Search the best afk point in the given radius search

#### What're partial chunks and absolute chunks?

If a chunk is half inside the despawn sphere(or also the exclusion sphere of 24 radius) and half outside, it will only add to the count 0.5 chunks.
The absolutes chunks are the adding of partial chunks for get a full chunk

### Options to launch:

#### Directly by cmd using command:

``` java -jar slimefinder.jar (seed) (mode)```

Then the program asks you the other parameters

#### Using the launch.bat:

Have the launch.bat end the jar file and double-click in the bat.
The bat script  will do a loop executing the jar file without having to set the seed each time.

#### How to do your own API:

You can download the source code from github, the file slimefinder.java in the core folder has the slimefinder class with all the methods used in the main file. You can create your own user interface according to your needs

I accept advice and suggestions
