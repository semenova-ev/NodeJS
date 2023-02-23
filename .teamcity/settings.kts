import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.script

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

version = "2022.10"

project {
    defaultTemplate = RelativeId("TestNodejsTemplate")

    buildType(TestNodeJSMacOS11BigSur)
    buildType(TestNodeJSWindows2019)
    buildType(TestNodeJSUbuntu2204)
    buildType(TestNodeJSUbuntu2004)
    buildType(TestNodeJSMacOS12Monterey)
    buildType(TestNodeJSWindows2022)

    template(TestNodejsTemplate)
}

object TestNodeJSMacOS11BigSur : BuildType({
    templates(TestNodejsTemplate)
    name = "Test NodeJS (macOS 11 BigSur)"

    requirements {
        contains("teamcity.agent.os.name", "macos-bigsur", "RQ_4")
    }
    
    disableSettings("RUNNER_28")
})

object TestNodeJSMacOS12Monterey : BuildType({
    templates(TestNodejsTemplate)
    name = "Test NodeJS (macOS 12 Monterey)"

    requirements {
        contains("teamcity.agent.os.name", "macos-monteray", "RQ_4")
    }
    
    disableSettings("RUNNER_28")
})

object TestNodeJSUbuntu2004 : BuildType({
    templates(TestNodejsTemplate)
    name = "Test NodeJS (Ubuntu 20.04)"

    requirements {
        equals("teamcity.agent.os.name", "ubuntu-20.04", "RQ_7")
    }
    
    disableSettings("RUNNER_28")
})

object TestNodeJSUbuntu2204 : BuildType({
    templates(TestNodejsTemplate)
    name = "Test NodeJS (Ubuntu 22.04)"

    requirements {
        equals("teamcity.agent.os.name", "ubuntu-20.04", "RQ_7")
    }
    
    disableSettings("RUNNER_28")
})

object TestNodeJSWindows2019 : BuildType({
    templates(TestNodejsTemplate)
    name = "Test NodeJS (Windows 2019)"

    requirements {
        contains("teamcity.agent.os.name", "windows-server-2019", "RQ_1")
    }
    
    disableSettings("RUNNER_28")
})

object TestNodeJSWindows2022 : BuildType({
    templates(TestNodejsTemplate)
    name = "Test NodeJS (Windows 2022)"

    requirements {
        contains("teamcity.agent.os.name", "windows-server-2022", "RQ_1")
    }
    
    disableSettings("RUNNER_28")
})

object TestNodejsTemplate : Template({
    name = "test-nodejs-template"

    steps {
        script {
            name = "Pause at the start"
            id = "RUNNER_28"
            enabled = false
            scriptContent = """
                echo "*** START: pause for 3000 secs ***"
                sleep 3000
            """.trimIndent()
        }
        script {
            name = "Test NPM install"
            id = "RUNNER_53"
            scriptContent = """
                npm -v
                npm install -g editorconfig
                yarn install
            """.trimIndent()
        }
        script {
            name = "Pause at the end"
            id = "RUNNER_29"
            enabled = false
            scriptContent = """
                echo "*** START: pause for 3000 secs ***"
                sleep 3000
            """.trimIndent()
        }
    }
})
