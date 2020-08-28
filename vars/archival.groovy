def archival() {

    publishHTML(target: [allowMissing: true,
         alwaysLinkToLastBuild: false,
         keepAll: true,
         reportDir: 'target/site/jacoco/',
         reportFiles: 'index.html',
         reportName: 'Code Coverage'
    ])

    step([$class: 'JUnitResultArchiver',
          testResults: 'target/surefire-reports/TEST-*.xml'
    ])

    step([$class: 'ArtifactArchiver',
          artifacts: "target/*.?ar",
          excludes: null
    ])
/*
    stash name: 'everything',
            excludes: 'test-results/**',
            includes: '**'

    node('windows') {
        bat 'dir'
        bat 'del /S /Q *'
        unstash 'everything'
        bat 'dir'

    }*/
}
