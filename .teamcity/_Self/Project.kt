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

    buildType(OctopusCreateRelease)
    buildType(Maven)
    buildType(NUnit)
    buildType(DockerCompose)
    buildType(Unity)
    buildType(Gradle)
    buildType(Python)
    buildType(VisualStudio)
    buildType(NuGetPack)
    buildType(PowerShell)
    buildType(DockerWrapper)
    buildType(SSHUpload_1)
    buildType(CommandLine)
    buildType(NuGetInstaller)
    buildType(OctopusPackPackage)
    buildType(DockerCommand)
    buildType(Nodejs)
    buildType(DotNET)
    buildType(OctopusPushPackage)
    buildType(SSHExec_1)
})
