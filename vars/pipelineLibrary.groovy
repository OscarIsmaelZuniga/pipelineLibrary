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
               checkout()
            }
         }
         stage('compiling packaging'){
            steps{
               compilePackage()
            }
         }
         stage('archival'){
            steps{
               archival()
            }
         }
         stage('Deploy to staging'){
            steps{
               deploy()
            }
         }
      }
   }
}