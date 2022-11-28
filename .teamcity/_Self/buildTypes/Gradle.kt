package _Self.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.perfmon
import jetbrains.buildServer.configs.kotlin.buildSteps.gradle
import jetbrains.buildServer.configs.kotlin.triggers.vcs

object Gradle : BuildType({
    name = "Gradle"

    vcs {
        root(_Self.vcsRoots.HttpsGithubComSemenovaEvGradleGitRefsHeadsMaster)
    }

    steps {
        gradle {
            tasks = "clean build"
            gradleWrapperPath = ""
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
