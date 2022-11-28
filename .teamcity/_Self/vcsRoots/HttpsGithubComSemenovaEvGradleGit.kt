package _Self.vcsRoots

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

object HttpsGithubComSemenovaEvGradleGit : GitVcsRoot({
    name = "https://github.com/semenova-ev/Gradle.git"
    url = "https://github.com/semenova-ev/Gradle.git"
    branch = "refs/heads/master"
})
