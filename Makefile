JFAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

classpath:= \
	$jai_core.jar \
	$jai_codec.jar \
	$mlibwrapper.jar


# Convert the spaces to colons.  This trick is from 
# the make info file.
empty:=
space:= $(empty) $(empty)
classpath:=     $(subst $(space),:,$(classpath))

CLASSES = \
	ImageViewer.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
