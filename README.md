# Backend File Task

An application to read files in CSV, JSON and XML formats, combine the data set of each file type and output in the
respective formats.

### Assumptions:
1. The input csv is of reasonable size and does not need to be read line by line.
2. Dom XML processor is slow but could be changed to JAXP.
 
```
cmd> [application] [csvfile] [jsonfile] [xmlfile] [csvfileoutput] [jsonfileoutput] [xmlfileoutput]
```