# Vulnerapp

-- A Vulnerable Sample Spring Boot Application

This application uses a relatively modern stack but is still vulernable to a set of attacks.
Featuring:

- [XSS](https://portswigger.net/web-security/cross-site-scripting)
- [SQLi](https://portswigger.net/web-security/sql-injection)
- [CSRF](https://portswigger.net/web-security/csrf)
- [SSRF](https://portswigger.net/web-security/ssrf)
- Fake Logins
- Info Exposure
- Plain Passwords
- ...

```console
./gradlew bootRun
```

# Diskussion und Selbstevaluation

## Diskussion:

In dieser Aufgabe geht es darum, die Sicherheit einer Applikation durch die Implementierung gängiger
Sicherheitsmaßnahmen zu verbessern, während das grundlegende Verhalten der Applikation beibehalten wird. Im Folgenden
werde ich die implementierten Sicherheitsmechanismen diskutieren, weitere mögliche Sicherheitsmaßnahmen erörtern und
potenzielle Schwierigkeiten bei der Implementierung reflektieren.

1. Verwendung von korrekten REST-Verben:
   Die Verwendung korrekter REST-Verben wie GET, POST, PUT und DELETE ist wichtig, um die Sicherheit der Applikation zu
   verbessern. Indem wir die entsprechenden Verben verwenden, stellen wir sicher, dass die Funktionen der Applikation
   entsprechend ihrer vorgesehenen Verwendung aufgerufen werden und unerwünschte Nebeneffekte vermieden werden.

2. Implementierung einer Authentifizierungslösung:
   Die Implementierung einer Authentifizierungslösung wie BasicAuth verbessert die Sicherheit der Applikation, indem sie
   den Zugriff auf geschützte Ressourcen auf authentifizierte Benutzer beschränkt. Durch die Verwendung von Benutzername
   und Passwort wird sichergestellt, dass nur autorisierte Benutzer auf die Applikation zugreifen können.

3. Enforce RBAC:
   Die Umsetzung von Role-Based Access Control (RBAC) ermöglicht es uns, die Funktionalitäten der Applikation auf
   verschiedene Benutzerrollen zu verteilen. Indem wir zwischen Benutzer- und Admin-Services unterscheiden, können wir
   sicherstellen, dass sensible Aktionen oder Daten nur von autorisierten Administratoren durchgeführt oder angezeigt
   werden können.

4. Aktivieren von CSRF-Protection:
   CSRF-Protection (Cross-Site Request Forgery) verhindert, dass bösartige Websites oder Angreifer Aktionen im Namen des
   authentifizierten Benutzers durchführen. Durch die Implementierung von CSRF-Protection wird ein zufälliger Token
   generiert und in jeder Anfrage übermittelt. Der Server überprüft, ob der Token gültig ist, um sicherzustellen, dass
   die Anfrage vom erwarteten Benutzer stammt.

5. Implementierung einer sicheren Passwort-Speicherung:
   Durch die Verwendung von sicheren Passwort-Speichertechniken wie Hashing und Passwortregeln wird die Sicherheit der
   Applikation erhöht. Passwörter sollten niemals im Klartext gespeichert werden. Stattdessen wird das Passwort des
   Benutzers mit einem kryptografischen Hash-Algorithmus gehasht und nur der Hashwert gespeichert. Beim Vergleich von
   Passwörtern wird der Hashwert des eingegebenen Passworts mit dem gespeicherten Hashwert verglichen.

6. Strikte Inputvalidierung:
   Die strikte Validierung von Benutzereingaben sowohl auf REST-Endpunkten als auch in der Datenbank ist entscheidend,
   um Sicherheitslücken wie SQL-Injection (SQLi) und Cross-Site Scripting (XSS) zu verhindern. Durch die Überprüfung und
   Filterung der Eingaben können potenziell schädliche Befehle oder Skripte abgewehrt werden.

7. Behebung der initialen Sicherheitslücken:
   Es ist wichtig, die anfänglichen Sicherheitslücken wie SQL-In jection (SQLi), Cross-Site Scripting (XSS) und CSRF zu
   beheben. Dies kann durch die Implementierung der oben genannten
   Sicherheitsmechanismen erreicht werden. SQL-Injection kann verhindert werden, indem parametrisierte Abfragen oder
   Prepared Statements verwendet werden. XSS kann durch die strikte Validierung und Filterung von Benutzereingaben sowie
   das Escapen von Ausgabedaten verhindert werden. CSRF kann durch die Implementierung von CSRF-Protection-Mechanismen
   verhindert werden.

Bei der Implementierung dieser Sicherheitsmaßnahmen können verschiedene Schwierigkeiten auftreten. Einige mögliche
Herausforderungen könnten sein:

- Komplexität der Implementierung: Die Umsetzung einiger Sicherheitsmechanismen erfordert möglicherweise umfangreiche
  Änderungen im Code und kann technisch anspruchsvoll sein.
- Kompatibilität und Interoperabilität: Bei der Implementierung von zusätzlichen Sicherheitsmechanismen müssen
  möglicherweise vorhandene Systeme oder Komponenten berücksichtigt werden, um sicherzustellen, dass sie reibungslos
  zusammenarbeiten.
- Benutzerfreundlichkeit: Die Verbesserung der Sicherheit darf nicht zu Lasten der Benutzerfreundlichkeit gehen. Es ist
  wichtig, dass die Sicherheitsmaßnahmen angemessen umgesetzt werden, ohne den Benutzern eine übermäßige Belastung
  aufzuerlegen.
- Performance: Einige Sicherheitsmechanismen können die Performance der Applikation beeinflussen. Es ist wichtig, die
  Auswirkungen auf die Leistung zu berücksichtigen und gegebenenfalls Optimierungen vorzunehmen.

Insgesamt ist es wichtig, dass Sicherheitsmaßnahmen kontinuierlich überprüft und aktualisiert werden, um auf neue
Bedrohungen und Angriffsmethoden zu reagieren. Eine gründliche Planung, Implementierung und regelmäßige Überprüfung der
Sicherheitsmechanismen sind entscheidend, um die Sicherheit der Applikation aufrechtzuerhalten und potenzielle
Schwachstellen zu minimieren.

## Selbstevaluation:
In diesem Projekt konnten wir die meisten der grundlegenden Sicherheitsanforderungen erfolgreich umsetzen. Es ist jedoch
zu beachten, dass aufgrund von Zeitbeschränkungen die Implementierung der CSRF-Protection leider nicht abgeschlossen
werden konnte. Dies ist ein Bereich, der in Zukunft weiter verbessert werden sollte, um die Sicherheit der Applikation
zu stärken.

Die anderen Sicherheitsmechanismen wurden zumindest in minimaler Form bereits umgesetzt, um ein gewisses Maß an
Sicherheit zu gewährleisten. In Zukunft könnten diese Aspekte weiter optimiert werden, um noch robustere
Sicherheitsvorkehrungen zu treffen.

Es ist bedauerlich, dass aufgrund von Zeitmangel nicht alle gewünschten Sicherheitsmaßnahmen vollständig implementiert
werden konnten. In Zukunft sollten wir sicherstellen, dass genügend Zeit für die Planung, Implementierung und
Überprüfung aller erforderlichen Sicherheitsmechanismen eingeplant wird.

Die nicht implementierte CSRF-Protection ist ein bedeutender Aspekt, der die Sicherheit der Applikation erheblich
verbessern könnte. Es wäre ratsam, die Implementierung dieser Maßnahme als Priorität zu behandeln und eine sorgfältige
Überprüfung durchzuführen, um sicherzustellen, dass sie ordnungsgemäß funktioniert.

Trotz der unvollständigen Implementierung der CSRF-Protection haben wir dennoch einen wichtigen Schritt gemacht, indem
wir die grundlegenden Sicherheitsmechanismen wie korrekte REST-Verben, Authentifizierungslösungen, RBAC, sichere
Passwort-Speicherung und strikte Inputvalidierung umgesetzt haben. Dies zeigt unser Engagement für die Sicherheit der
Applikation und legt eine solide Grundlage für zukünftige Verbesserungen.

Insgesamt haben wir in diesem Projekt Fortschritte bei der Sicherheitsverbesserung der Applikation gemacht. Es bleibt
jedoch noch Raum für Weiterentwicklung und Optimierung, insbesondere bei der Implementierung der CSRF-Protection und der
Verfeinerung der bereits umgesetzten Sicherheitsmechanismen. Für zukünftige Projekte sollten wir die Bedeutung der
Sicherheit von Anfang an berücksichtigen und angemessene Ressourcen und Zeit für die Implementierung aller
erforderlichen Sicherheitsvorkehrungen einplanen.




