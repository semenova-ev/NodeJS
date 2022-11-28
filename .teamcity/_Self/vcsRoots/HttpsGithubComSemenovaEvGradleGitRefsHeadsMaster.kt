package _Self.vcsRoots

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

object HttpsGithubComSemenovaEvGradleGitRefsHeadsMaster : GitVcsRoot({
    name = "https://github.com/semenova-ev/Gradle.git#refs/heads/master"
    url = "https://github.com/semenova-ev/Gradle.git"
    branch = "refs/heads/master"
    branchSpec = "refs/heads/*"
})
