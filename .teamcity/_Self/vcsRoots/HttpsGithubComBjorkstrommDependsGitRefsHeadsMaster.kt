package _Self.vcsRoots

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

object HttpsGithubComBjorkstrommDependsGitRefsHeadsMaster : GitVcsRoot({
    name = "https://github.com/bjorkstromm/depends.git#refs/heads/master"
    url = "https://github.com/bjorkstromm/depends.git"
    branch = "refs/heads/master"
    branchSpec = "refs/heads/*"
})
