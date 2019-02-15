package com.sankuai.qualityplugin

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class QualityTask extends DefaultTask {
    @TaskAction
    void quality() {
        File file = new File(project.rootDir.absolutePath + "/quality.txt")
        if (!file.exists()) {
            file.createNewFile()
        }
    }
}