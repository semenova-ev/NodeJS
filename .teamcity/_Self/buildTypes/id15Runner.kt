package _Self.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.perfmon
import jetbrains.buildServer.configs.kotlin.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.triggers.vcs

object id15Runner : BuildType({
    id("15Runner")
    name = "15Runner"

    vcs {
        root(_Self.vcsRoots.HttpsGithubComSemenovaEvMavenRunnerGitRefsHeadsMaster)
    }

    steps {
        maven {
            goals = "clean test"
            pomLocation = "ch-simple/pom.xml"
            runnerArgs = "-Dmaven.test.failure.ignore=true"
        }
    }

    triggers {
        vcs {
        }
    }

    features {
        perfmon {
        }
    }
})
