# English to Ancient Text Language Translator

An ancient language was recently uncovered which appears to be a close English language derivative. A group of researchers 
requires a program to translate English into this ancient text. 

## Translation Rules

1. If a word has no letters, don't translate it.
2. All punctuation should be preserved.
3. If a word begins with a capital letter, then the translated word should too.
4. Separate each word into two parts. The first part is called the _"prefix"_ and extends from the beginning of the word up 
to, but not including, the first vowel. (The letter _"y"_ will be considered a vowel.) The rest of the word is called 
the _"stem"_. The translated text is formed by reversing the order of the prefix and stem and adding the letters _"ay"_ to 
the end. For example, _"sandwich"_ is composed of _"s"_ (the prefix) + _"andwich"_ (the stem) + _"ay"_ and would translate 
to _"andwichsay"_.
6. If a word contains no consonants, let the prefix be empty and the word be the stem. The word ending should be _"yay"_ 
instead of merely _"ay"_. For example, _"l"_ would be _"lyay"_.

## Examples

English word                     | Ancient Text
:-----------                     | :-----------
Stop                             | Opstay
No littering                     | Onay itteringlay
No shirts, no shoes, no service  | Onay irtsshay, onay oesshay, onay ervicesay
No persons under 14 admitted     | Onay ersonspay underay 14 admitteday
Hey buddy, get away from my car! | Eyhay uddybay, etgay awayay omfray ymay arcay!
bcd is misspelled!!!             | bcdyay isay isspelledmay!!!

Pete Sattler   
17 February 2014  
_peter@sattler22.net_  
