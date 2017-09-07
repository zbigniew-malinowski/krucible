# krucible
Kotlin syntax highlighting for Atlassian Crucible

### Usage
Just install [kotlin.def](krucible/kotlin.def) file on Crucible server as described 
[here](https://confluence.atlassian.com/fishkb/configure-syntax-highlighting-for-non-standard-file-extensions-300811223.html).

###Modifications
If you need to add/remove some keywords, you can edit *kotlin_keywords.txt* and 
[use](https://kotlinlang.org/docs/tutorials/command-line.html) *krucible.kts* to generate a proper prefix tree and update 
*kotlin.def* configuration file.

