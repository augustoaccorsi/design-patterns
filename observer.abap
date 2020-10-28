*&---------------------------------------------------------------------*
*& Report Z_AA_OBSERVER
*&---------------------------------------------------------------------*
*&
*&---------------------------------------------------------------------*
REPORT Z_AA_OBSERVER.

*** SERVER PART ***
CLASS lcl_server DEFINITION.
  PUBLIC SECTION.
    METHODS:
      put_message IMPORTING i_msg TYPE string.
    EVENTS
      new_message EXPORTING VALUE(msg) TYPE string.
ENDCLASS.

CLASS lcl_server IMPLEMENTATION.
  METHOD put_message.
*** Debug info ***
    WRITE:/ 'Server received new message:'.
    WRITE:/ '  ', i_msg.

    WRITE:/ 'Server raises event NEW_MESSAGE'.
    SKIP 2.
    RAISE EVENT new_message EXPORTING msg = i_msg.
  ENDMETHOD.
ENDCLASS.

*** CLIENT INTERFACE ***
INTERFACE lif_client.
  METHODS:
    send IMPORTING i_msg TYPE string,
    on_new_message FOR EVENT new_message OF lcl_server
      IMPORTING msg.
  DATA:
    mo_server TYPE REF TO lcl_server READ-ONLY.
ENDINTERFACE.

*** DIALOG CLIENT ***
CLASS lcl_dialog_client DEFINITION.
  PUBLIC SECTION.
    INTERFACES lif_client.
    METHODS:
      constructor
        IMPORTING
          io_server TYPE REF TO lcl_server.
ENDCLASS.

CLASS lcl_dialog_client IMPLEMENTATION.
  METHOD constructor.
    lif_client~mo_server = io_server.
  ENDMETHOD.

  METHOD lif_client~send.
*** Debug info ***
    WRITE: / 'DIALOG is sending new message'.
    lif_client~mo_server->put_message(
      EXPORTING
        i_msg = i_msg
    ).
  ENDMETHOD.

  METHOD lif_client~on_new_message.
*** Debug info ***
    WRITE: / 'DIALOG received new message:'.
    WRITE: / '  ', msg.
  ENDMETHOD.
ENDCLASS.

*** PRINTER CLIENT ***
CLASS lcl_printer_client DEFINITION.
  PUBLIC SECTION.
    INTERFACES lif_client.
    METHODS:
      constructor
        IMPORTING
          io_server TYPE REF TO lcl_server.
ENDCLASS.

CLASS lcl_printer_client IMPLEMENTATION.
  METHOD constructor.
    lif_client~mo_server = io_server.
  ENDMETHOD.

  METHOD lif_client~send.
*** Debug info ***
    WRITE: / 'PRINTER is sending new message'.
    lif_client~mo_server->put_message(
      EXPORTING
        i_msg = i_msg
    ).
  ENDMETHOD.

  METHOD lif_client~on_new_message.
*** Debug info ***
    WRITE: / 'PRINTER received new message:'.
    WRITE: / '  ', msg.
  ENDMETHOD.
ENDCLASS.

*** TEST PROGRAM ***
START-OF-SELECTION.
  DATA:
    lo_server   TYPE REF TO lcl_server,
    lo_client_1 TYPE REF TO lif_client,
    lo_client_2 TYPE REF TO lif_client.

* Creating server instance
  CREATE OBJECT lo_server.
* Creating dialog client instance
  CREATE OBJECT lo_client_1 TYPE lcl_dialog_client
    EXPORTING
      io_server = lo_server.
* Creating printer client instance
  CREATE OBJECT lo_client_2 TYPE lcl_printer_client
    EXPORTING
      io_server = lo_server.

* Register event handlers
  SET HANDLER lo_client_1->on_new_message FOR lo_server.
  SET HANDLER lo_client_2->on_new_message FOR lo_server.

* Send new message from dialog client to server
  lo_client_1->send( 'Hello world' ).