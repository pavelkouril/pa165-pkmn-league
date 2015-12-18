# PA165 Project (Seminar 03) - Pokémon League

[![Build Status](https://travis-ci.org/pavelkouril/pa165-pkmn-league.svg)](https://travis-ci.org/pavelkouril/pa165-pkmn-league)

## Running REST Module

More info in `pkmnleague-rest` directory.

## Running Web Module

First, build the entire project using maven, via

```
$ mvn clean install
```

Then go into the `pkmnleague-web` directory, and run

```
$ mvn tomcat7:run
```

After the application starts, it will be accessible on the `http://localhost:8080/pa165` URL.

To log in, you can use the following credentials:


| Username        | Password | Role |
----------------- |-----------------
| red@example.com | heslo   | trainer |
| blue@example.com | heslo | gym leader |
| brock@example.com | heslo | gym leader |
| misty@example.com | heslo | gym leader |

You can either create a gym for Red to make him a Gym Leader or you can try to award Badge from Misty to Red, since he doesn't have it already.


