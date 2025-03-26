; Script Inno Setup - Installation de l'application GestionClubs

[Setup]
AppName=GestionClubs
AppVersion=1.0
DefaultDirName={pf}\GestionClubs
DefaultGroupName=GestionClubs
OutputDir=output
OutputBaseFilename=Setup_GestionClubs
Compression=lzma
SolidCompression=yes
DisableDirPage=no
ArchitecturesInstallIn64BitMode=x64

[Files]
; Le fichier EXE généré par Launch4j
Source: "C:\Users\Yoga\Documents\NetBeansProjects\GestionClubs\GestionC.exe"; DestDir: "{app}"; Flags: ignoreversion

; Toutes les bibliothèques dans lib
Source: "C:\Users\Yoga\Documents\NetBeansProjects\GestionClubs\dist\lib\*"; DestDir: "{app}\lib"; Flags: ignoreversion recursesubdirs createallsubdirs

; Icône (optionnel)
Source: "C:\Users\Yoga\Documents\NetBeansProjects\GestionClubs\iconeapp_pRp_icon.ico"; DestDir: "{app}"; Flags: ignoreversion

[Icons]
; Raccourci vers l'application sur le bureau
Name: "{commondesktop}\GestionClubs"; Filename: "{app}\GestionC.exe"; IconFilename: "{app}\iconeapp_pRp_icon.ico"

; Raccourci dans le menu démarrer
Name: "{group}\GestionClubs"; Filename: "{app}\GestionC.exe"; IconFilename: "{app}\iconeapp_pRp_icon.ico"

[Run]
Filename: "{app}\GestionC.exe"; Description: "Lancer GestionClubs"; Flags: nowait postinstall skipifsilent
