package _Self.vcsRoots

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

object HttpsGithubComSemenovaEvMultiTestOldDslGitRefsHeadsMain : GitVcsRoot({
    name = "https://github.com/semenova-ev/multi-test-old-dsl.git#refs/heads/main"
    url = "https://github.com/semenova-ev/multi-test-old-dsl.git"
    branch = "refs/heads/main"
    branchSpec = "refs/heads/*"
})
