def call (body) {
   def config = [:]
   body.resolveStrategy = Closure.DELEGATE_FIRST
   body.delegate = config
   body()

   pipeline {
      agent any
      stages {
         stage('checkout') {
            steps {
               checkout scm
               println 'Primer hello world'
               helloWorld()
            }
         }
      }
   }
}