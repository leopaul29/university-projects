grep "^.$" dicoUTF8.txt | more
grep "^$" dicoUTF8.txt | more
grep ".." dicoUTF8.txt | more
grep "^.\{0,2\}$" dicoUTF8.txt | more
grep "^.\{2,5\}$" dicoUTF8.txt | more
grep "x" dicoUTF8.txt | more
grep "^[^x]*$" dicoUTF8.txt | more
grep "^[^x]*x[^x]*$" dicoUTF8.txt | more
grep "^x" dicoUTF8.txt | more
grep "x$" dicoUTF8.txt | more
grep "e.*e" dicoUTF8.txt | more
grep "^[^e]*e[^e]*e[^e]*$" dicoUTF8.txt | more
grep "[xy]" dicoUTF8.txt | more
grep "^[^yx]*$" dicoUTF8.txt | more
grep "^[^xy]*[xy][^yx]*$" dicoUTF8.txt | more
grep "^[xy]" dicoUTF8.txt | more
grep "^[^xy]*$" dicoUTF8.txt | more
grep "^[^xy]*[xy][^xy]*[xy]" dicoUTF8.txt | more
grep "^[^xy]*[xy][^xy]*[xy][^xy]*$" dicoUTF8.txt | more
grep "^\([a-z]\)[^ ]*\1$" dicoUTF8.txt | more
grep "[0-9]" textchiffr.txt
grep "^[^[0-9]]*$" textchiffr.txt
grep "^[^[0-9]]*[0-9][^[0-9]]*$" textchiffr.txt 
grep "^[0-9]" textchiffr.txt
grep "[0-9]$" textchiffr.txt
grep "^[0-9]*[0-9]$" textchiffr.txt
grep "^\([0-9]\).*[0-9]$" textchiffr.txt
