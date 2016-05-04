# Vote Counting & Publishing system

Vote Counting

[![Build Status](https://travis-ci.org/Arquisoft/VoteCounting_i2.svg?branch=master)](https://travis-ci.org/Arquisoft/VoteCounting_i2)
[![Codacy Badge](https://api.codacy.com/project/badge/grade/c442c416527d4d14aaf004b134785577)](https://www.codacy.com/app/jelabra/VoteCounting_i2)
[![codecov.io](https://codecov.io/github/Arquisoft/VoteCounting_i2/coverage.svg?branch=master)](https://codecov.io/github/Arquisoft/VoteCounting_i2?branch=master)

# Build and run
In order to ease the build and run phase docker compose is used, you just need to run:
``` bash
$ docker-compose up
```
And the service will be started in the port `8080` of your docker machine.
Once the service is up, you can run a vote counting like this:
``` bash
$ docker exec -it counting ./run_counting
```

# Test data
For provide a simple example you can fill the database with votes by run this:
``` bash
$ docker exec -it counting ./fill.sh
```

# Authors

* Jose Labra
* Fabio Martinez Gonzalez
* Andrea Vega Campos
* Pablo Mendendez Barrientos
* Roberto Fernandez Diaz
* Luis Emilio Velasco Sanchez




