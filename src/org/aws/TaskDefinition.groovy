package org.aws

import groovy.json.JsonSlurper

// the idea is to use OO to get things done instead of using cli
class TaskDefinition {
  def taskDefinition

  /**
   * Get the family name to get the task definition
   */
  def getTaskDefinition(family) {
    def jsonSlurper = new JsonSlurper()
    def object = slurper.parseText(
      sh(returnStdout: true,
        script: "aws ecs describe-task-definition --task-definition ${family}"
      )
    )
    return assert object instanceof Map
    //taskDefinition = object["taskDefinition"]
  }
}
