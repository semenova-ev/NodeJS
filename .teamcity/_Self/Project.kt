package _Self

import _Self.buildTypes.*
import _Self.vcsRoots.*
import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.Project

object Project : Project({

    vcsRoot(HttpsGithubComSemenovaEvMultiTestOldDslGitRefsHeadsMain)
    vcsRoot(HttpsGithubComSemenovaEvMavenRunnerGitRefsHeadsMaster)
    vcsRoot(HttpsGithubComSemenovaEvGradleGit)
    vcsRoot(HttpsGithubComSemenovaEvGradleGitRefsHeadsMaster)
    vcsRoot(HttpsGithubComBjorkstrommDependsGitRefsHeadsMaster)

    buildType(id6Runner)
    buildType(id15Runner)
    buildType(id5Runner)
    buildType(GradleRunner_2)
    buildType(id7Runner)
    buildType(id16Runner)
    buildType(id1Runner)
    buildType(id2Runner)
    buildType(id12Runner)
    buildType(id3Runner)
    buildType(id9Runner)
    buildType(id18Runner)
    buildType(id11Runner)
    buildType(id17Runner)
    buildType(MavenRunner)
    buildType(id13Runner)
    buildType(id10Runner)
    buildType(id14Runner)
    buildType(id4Runner)
    buildType(id8Runner)
})
