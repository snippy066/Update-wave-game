# Updated-wave-game

Updated-wave-game for an Open Source Java Project

## dependencies

All the following dependencies are free provided your project is Open Source.

- Source repository and VCS

    used [GitHub](https://github.com/).
    Of course you can use another VCS here.
    What is nice with GitHub is the integration with CI, issue management, and project boards (see below).
    So here you only have to create a repository.

    You must sign your work (commits and tags). See [here](https://git-scm.com/book/en/v2/Git-Tools-Signing-Your-Work).
    
    Structured commit messages help in understanding changes, and perform automated tasks such as generating changelogs.
    We propose to follow the [Angular JS commit guidelines](https://github.com/angular/angular.js/blob/master/CONTRIBUTING.md#commit)
    (see also the [variation given here](https://karma-runner.github.io/1.0/dev/git-commit-msg.html)). 

    In order to follow easily these guidelines (conventional format) you may:
    
    - install and use the [commitizen command line utility](http://commitizen.github.io/cz-cli/),
      *e.g.*, use `git cz` instead of `git commit -m "..."` or use the plugin for your IDE (*e.g.*, see [here](https://github.com/KnisterPeter/vscode-commitizen)). The adapter we use is `cz-conventional-changelog`.
      
    - install and use the [clog command line utility](https://github.com/clog-tool/clog-cli) to generate change logs
       from commit messages that respect the conventional format.
       
    If you use to work with several projects at the same time, 
    you may consider using the [uncommitted](https://pypi.python.org/pypi/uncommitted) command.

- Continuous Integration

    We will use [Travis CI](https://travis-ci.org/) and its connection to GitHub.
    See [here](https://docs.travis-ci.com/user/for-beginners) how to activate this for your project.
    Then, the provided ```.travis.yml``` and ```build.gradle``` files will do the job.

    You can use other CI services that have equivalent features. We will add information about GitHub actions in a next version of this template.
    
    To follow your issues (and the work on them) you can use one of:
    
    - [Github Project Boards](https://docs.github.com/en/free-pro-team@latest/github/managing-your-work-on-github/about-project-boards)
    - [GitKraken Boards](https://www.gitkraken.com/boards) and see [here](https://github.com/marketplace/gitkraken-glo-boards) for the integration between GitKraken Boards and GitHub
    - [Trello](https://trello.com), and see [here](https://blog.trello.com/github-and-trello-integrate-your-commits) for the integration between Trello and GitHub
    - unfortunately, [Waffle](https://waffle.io) is now out of the game

- Code Analysis

	You can use [Codacy](https://www.codacy.com) for code analysis.
	See [here](https://support.codacy.com/hc/en-us/sections/201760869-Integrations) how to activate this for your project.
	
  Another solution is to use [Code Climate](https://codeclimate.com/dashboard). See [here](https://docs.codeclimate.com/docs/getting-started-with-code-climate) how to activate this for your project.

  You may also use [SonarQube](http://www.sonarqube.org/) for code analysis.
  For this we use [sonarcloud.io](https://sonarcloud.io). See information [here](https://docs.travis-ci.com/user/sonarcloud/) on how to setup Travis CI to work with SonarCloud.

- Test Coverage

    We will use [JaCoCo](http://eclemma.org/jacoco/) to produce test coverage reports.
    For the time being it does not support excluding private constructors from the analysis.
    Hence you won't get 100% coverage in the reports if you use them
    (anyway, remember 100% coverage is not an objective in itself).
    To have JaCoCo support, nothing to do, the provided ```.travis.yml``` and ```build.gradle``` files will do the job.

    We will use [Coveralls](https://coveralls.io/) and [Codecov](https://codecov.io/) to produce test coverage history and statistics.
    See respectively
    [dead link](https://coveralls.zendesk.com/hc/en-us), and
    [here](https://github.com/codecov/example-gradle)
    how to activate this for your project.
    Then, the provided ```.travis.yml``` and ```build.gradle``` files will do the job.
    
    Coverage information can also be sent to Codacy (more information to come).

- Logging

    We will use [Apache Log4j 2](http://logging.apache.org/log4j/2.x/) for logging.
    A very basic set configuration files, in YAML format, is provided.
    More information is [here](http://logging.apache.org/log4j/2.x/manual/configuration.html).
    Note the use of distinct configurations files for the run (```src/main/resources/log4j2.yml```) and for the test (```src/main/resources/log4j2-test.yml```).
    This enables you, e.g., to log different things and present them in different ways in test or in production.
    Of course different logging APIs can be used instead of Log4j.
    For example if you use ``java.util.logging`` you can remove the Log4j and jackson-dataformat dependencies from ```build.gradle```, and you don't need the Log4j configuration files.

- License Badges

    We will use [shields.io](https://img.shields.io) to generate the license badge automatically from the LICENSE file in the github repository.


- Documentation

