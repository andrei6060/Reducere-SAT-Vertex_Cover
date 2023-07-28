build: trial 

run_trial:
	java task1

trial: task1.java Task.java
	javac $^

clean:
	rm -f *.class

.PHONY: build clean