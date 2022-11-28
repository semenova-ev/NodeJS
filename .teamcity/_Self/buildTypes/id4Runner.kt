package _Self.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.perfmon
import jetbrains.buildServer.configs.kotlin.triggers.vcs

object id4Runner : BuildType({
    id("4Runner")
    name = "4Runner"

    vcs {
        root(_Self.vcsRoots.HttpsGithubComSemenovaEvMavenRunnerGitRefsHeadsMaster)
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
