import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.perfmon
import jetbrains.buildServer.configs.kotlin.buildSteps.gradle
import jetbrains.buildServer.configs.kotlin.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.triggers.vcs
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2022.04"

project {

    vcsRoot(HttpsGithubComSemenovaEvMultiTestOldDslGitRefsHeadsMain)
    vcsRoot(HttpsGithubComSemenovaEvMavenRunnerGitRefsHeadsMaster)
    vcsRoot(HttpsGithubComSemenovaEvGradleGit)
    vcsRoot(HttpsGithubComSemenovaEvGradleGitRefsHeadsMaster)

    buildType(MavenRunner)
    buildType(GradleRunner_2)
    buildType(Build)
}

object Build : BuildType({
    name = "Build"

    vcs {
        root(HttpsGithubComSemenovaEvGradleGitRefsHeadsMaster)
    }

    steps {
        script {
            scriptContent = "call gradle/.bat"
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

object GradleRunner_2 : BuildType({
    name = "GradleRunner"

    vcs {
        root(HttpsGithubComSemenovaEvGradleGitRefsHeadsMaster)
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

object MavenRunner : BuildType({
    name = "MavenRunner"

    vcs {
        root(HttpsGithubComSemenovaEvMavenRunnerGitRefsHeadsMaster)
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

object HttpsGithubComSemenovaEvGradleGit : GitVcsRoot({
    name = "https://github.com/semenova-ev/Gradle.git"
    url = "https://github.com/semenova-ev/Gradle.git"
    branch = "refs/heads/master"
})

object HttpsGithubComSemenovaEvGradleGitRefsHeadsMaster : GitVcsRoot({
    name = "https://github.com/semenova-ev/Gradle.git#refs/heads/master"
    url = "https://github.com/semenova-ev/Gradle.git"
    branch = "refs/heads/master"
    branchSpec = "refs/heads/*"
})

object HttpsGithubComSemenovaEvMavenRunnerGitRefsHeadsMaster : GitVcsRoot({
    name = "https://github.com/semenova-ev/MavenRunner.git#refs/heads/master"
    url = "https://github.com/semenova-ev/MavenRunner.git"
    branch = "refs/heads/master"
    branchSpec = "refs/heads/*"
})

object HttpsGithubComSemenovaEvMultiTestOldDslGitRefsHeadsMain : GitVcsRoot({
    name = "https://github.com/semenova-ev/multi-test-old-dsl.git#refs/heads/main"
    url = "https://github.com/semenova-ev/multi-test-old-dsl.git"
    branch = "refs/heads/main"
    branchSpec = "refs/heads/*"
})
