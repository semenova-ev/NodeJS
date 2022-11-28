package _Self.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.perfmon
import jetbrains.buildServer.configs.kotlin.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.triggers.vcs

object id5Runner : BuildType({
    id("5Runner")
    name = "5Runner"

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
