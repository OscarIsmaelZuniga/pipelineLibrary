def call (body) {
   def config = [:]
   body.resolveStrategy = Closure.DELEGATE_FIRST
   body.delegate = config
   body()

   mavenPipeline {
      agent any
      stages {
         stage('checkout') {
            steps {
               checkout scm
               println 'Hello World!'
            }
         }
      }
   }
}