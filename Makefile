build: trial rise redemption

run_trial:
	java task1

trial: task1.java Task.java
	javac $^

run_rise:
	java task2

rise: task2.java Task.java
	javac $^

run_redemption:
	java task3

redemption: task3.java Task.java
	javac $^

clean:
	rm -f *.class

.PHONY: build clean