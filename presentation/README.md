# Welcome to VIM World!

## 1. h,j,k,l
open some file, and try with "h,j,k,l"
and more: w,b,e,ge, W,B,E,gE
and more: ":q!", ":wq"

	jump to next-word. Then jump back to last-world.
	save all changes or abort all.

## 2. a,i,o,A,I,O
try them.
and more:  0, $, ^
and more: c,s,r

## 3. ".", u
repeat your last work by ".";
redo by "u"

	delete me;
	delete me;
	delete me;

## 4. f,t,F,T,/,?
and more  by ";", ",",n, N

	found X the this sentence.
	found a "CTRIP" in this md.

## 5.  View mode 

now a new Vim edit mode: View mode. Enter it by: v, V, Ctrl+v

	# 1.do format by vim:
	while(true) {
	int sum = 0;
	for(int i = 1; i < 10; i++) {
	sum += i;
	}
	}
		
	# 2. block edit:
	A	12		A	| 12
	B	23		B	| 23	
	C	34		C	| 34
		
	# 3. edit lines by one time:
	js1 = ../wrongpath/..
	js2 = ../wrongpath/..
	jslongNme3 = ../wrongpath/..

## 6. run Shell in VIM
try: ":!{cmd}"
	
	:!ls
	:!pwd
	# or more shells:
	:shell
	$... your shells
	$exit
	
## 7. more about movement

try: Ctrl-d,Ctrl-b,Ctrl-f,Ctrl-u, Ctrl-e,Ctrl-y
try: gg, G, zz
try: %
	
	console.log([{'a':1, 'b':2}])

##8. more about text selection
try: ci", vit, da<, 100Ctrl-a, 100Ctrl-x

	source:
	<a href="wrongUrl", value =100px>hello</a>	
	target:
	<a href="write", value =200px>world</a>

## 9. deletion and paste

try: dd, ddp, yyp, "0p

	yank aVeryLongWord;
	source: origin is deleteThisWord
	targe:  origin is aVeryLongWord

## 10. macro
try: q{register} ... q
	
	# Excise 1:
	change the word "BAD" in this BAD long sentence to the word "GOOD" by macro, to make things BAD.
	# Excise 2:
	source:
	1/. one
	2/. two
	3/. three
	target:
	1) One
	2) Two
	3) Three
	
## 11. misc.
try: ea, xp, ddp, yyp
try: <Edit Mode \>: Ctrl-r, Ctrl-o
other plugin...
integrated with IntelJ...

## 12. Bash shortcut

Command Editing Shortcuts

Ctrl + a – go to the start of the command line
Ctrl + e – go to the end of the command line
Ctrl + k – delete from cursor to the end of the command line
Ctrl + u – delete from cursor to the start of the command line
Ctrl + w – delete from cursor to start of word (i.e. delete backwards one word)
Ctrl + y – paste word or text that was cut using one of the deletion shortcuts (such as the one above) after the cursor
Ctrl + xx – move between start of command line and current cursor position (and back again)
Alt + b – move backward one word (or go to start of word the cursor is currently on)
Alt + f – move forward one word (or go to end of word the cursor is currently on)
Alt + d – delete to end of word starting at cursor (whole word if cursor is at the beginning of word)
Alt + c – capitalize to end of word starting at cursor (whole word if cursor is at the beginning of word)
Alt + u – make uppercase from cursor to end of word
Alt + l – make lowercase from cursor to end of word
Alt + t – swap current word with previous
Ctrl + f – move forward one character
Ctrl + b – move backward one character
Ctrl + d – delete character under the cursor
Ctrl + h – delete character before the cursor
Ctrl + t – swap character under cursor with the previous one
Command Recall Shortcuts

Ctrl + r – search the history backwards
Ctrl + g – escape from history searching mode
Ctrl + p – previous command in history (i.e. walk back through the command history)
Ctrl + n – next command in history (i.e. walk forward through the command history)
Alt + . – use the last word of the previous command
Command Control Shortcuts

Ctrl + l – clear the screen
Ctrl + s – stops the output to the screen (for long running verbose command)
Ctrl + q – allow output to the screen (if previously stopped using command above)
Ctrl + c – terminate the command
Ctrl + z – suspend/stop the command
Bash Bang (!) Commands

Bash also has some handy features that use the ! (bang) to allow you to do some funky stuff with bash commands.

!! - run last command
!blah – run the most recent command that starts with ‘blah’ (e.g. !ls)
!blah:p – print out the command that !blah would run (also adds it as the latest command in the command history)
!$ – the last word of the previous command (same as Alt + .)
!$:p – print out the word that !$ would substitute
!* – the previous command except for the last word (e.g. if you type ‘find some_file.txt /‘, then !* would give you ‘find some_file.txt‘)
!*:p – print out what !* would substitute
There is one more handy thing you can do. This involves using the ^^ ‘command’. If you type a command and run it, you can re-run the same command but substitute a piece of text for another piece of text using ^^ e.g.:
	
