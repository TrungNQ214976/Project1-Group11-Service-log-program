package dataio;

public class LogAttribute {
//	Mar 24 14:11:11	Date/Time Stamp
//	host	The Hostname of the system where this occurred (your server)
//	kernel:	Application Name (firewall rules are always kernel:)
//	DROP_ASL_INPUT	Firewall Rule Name
//	IN=eth0	Incoming Interface (This is only populated when the packet is coming into the server)
//	OUT=	Outgoing Interface (This is only populated when the packet is going out of the server)
//	MAC=00:50:56:bd:76:78:00:a0:c8:26:33:94:08:00	The MAC Address of the last hop upstream hardware that send the packet (usually this will be your upstream router)
//	SRC=1.2.3.4	Source IP (The IP address for the system that sent this packet)
//	DST=5.6.7.8	Destination IP (The IP address the source system requested this packet be sent to)
//	LEN=48	Total length of IP packet in bytes
//	TOS=0x00	Type Of Service field. This is rarely used, and is replaced on most systems by DS and ECN.
//	PREC=0x00	The "Precedence" Type of Service field. This is rarely used, and is replaced on most systems by DS and ECN.
//	TTL=115	Remaining "Time To Live" for this packet in "hops"
//	ID=12197	Unique ID for this IP datagram. If this is a fragment, all fragments share the same ID.
//	CE	ECN Flag, Congestion Experienced (optional)
//	DF	Dont Fragment Flag (optional)
//	MF	More Fragments to follow (optional)
//	PROTO=TCP	Protocol (For example, TCP or UDP)
//	SPT=3619	Source Port (The port the packet came from)
//	DPT=110	Destination Port (The port the source IP requested the packet go to)
//	SEQ=1917628740	Receive Sequence number
//	ACK=0	Same as the Receive Sequence number above, but for the other end of the TCP connection. Normally only seen on the reply packet.
//	WINDOW=65535	The TCP Receive Window size.
//	RES=0x00	Reserved bits. This field is used, optionally, for things like ECNE and CWR.
//	SYN URGP=0	Packet Flags.
//	OPT (020405B401010402)	TCP Options (optional)
	private String dateRegex = "[A-Za-z]+? +?[0-9]+? [0-9]+?:[0-9]+?:[0-9]+? ";
	private String hostNameRegex = "[^\\s]+?(?=\\skernel)";
	
}
