package com.sankuai.qualityplugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class QualityPlugin implements Plugin<Project> {

    void apply(Project project) {
        project.task("qualityTask", type: QualityTask)
    }
}