project.extra["p1"] = project.findProperty("p1") ?: "p1_from_build_file"
project.extra["p2"] = project.findProperty("p2") ?: "p2_from_build_file"

project.extra.apply {

}


println("p1 = ${extra["p1"]}")
println("p2 = ${extra["p2"]}")
println("${extra}")
println("${project.extra}")


tasks.register("printMyParams") {
    doLast {
        println("printMyParams start---")
//        println("p1 = ${project.findProperty("p1")}")
//        println("p2 = ${project.findProperty("p2")}")
//        println("p3 = ${project.findProperty("p3")}")
//        println("p4 = ${project.findProperty("p4")}")
//        println("${extra}")
//        project.extra.properties.forEach {
//            println("${it.key} = ${it.value}")
//        }

//
        println("extra[p1]=${project.extra["p1"]}")
        println("extra[p2]=${project.extra["p2"]}")
//        println("extra[p1]=${extra["p1"]}")
//        println("extra[p2]=${extra["p2"]}")
        println("printMyParams end---")
    }
}

//preBuild这个任务作用不明确，字面上的意思是build之前，理论上是 gradle build 执行之前会调用preBuild这个任务
//在执行preBuild之前先执行 printMyParams
// 定义 preBuild 任务并设置依赖关系
tasks.named("preBuild") {
    dependsOn("printMyParams")
}