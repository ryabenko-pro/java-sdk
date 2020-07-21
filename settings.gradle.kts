rootProject.name = "elarian"
include("lib")

val isAssembleTask = startParameter.taskRequests.find { it.args.contains("assemble") } != null

var examples = mutableListOf("java", "kotlin", "scala")
if (!isAssembleTask) { examples.add("android") }

examples.forEach {
    include(it)
    project(":$it").projectDir = file("examples/$it")
}
