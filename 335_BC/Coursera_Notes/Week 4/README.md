# Week 4 - Trust Essentials
## Decentralised Systems:
### Establishing trust in the blockchain:
- secure chain using protocols
- validate txns and blocks
- verify resource availability for txns
- executing and confirming the txns
#### Trust trail:
![Pasted image 20230212092618.png](./11.png)
- validate txn and check resources:
	- in bitcoin - about 20 criteria to do this
	- in ethereum txn - syntax, txn sign and hash, time stamp, nonce, gas limit, sender acc balance, fuel/gas points for smart contract exec is also checked.
- execute txns:
	- merkle tree hash of validated txns is computed in ethereum - **txn root** of the block header
	- all miners execute the txn for ether transfer and exec of smart contracts
	- state resulting from txns exec - used in computing merkle tree hash of the state - **state root** of block header
	- **receipt root** of the block header is also computed
## Consensus Protocol:
- secure chain = single main chain with consistent state
- every block added, adds to the trust level of the chain
- all candidate blocks are by a competing miner, so which one do we add?? method or protocol to  choose the next block?? --> proof of work
- proof of work - uses hashing
- PoW in bitcoin and ethereum
	- from the pov of the miner:
		- compute hash of block header elements - fixed
		- nonce - variable
		- hash < 2<sup>128</sup> for bitcoin / hash < func(difficulty) for ethereum
		- then puzzle solved
		- else change nonce and repeat the process
		- puzzle solved - broadcast winning bock which is verified by the miners
		- non-winning - added to local copy of chain
		- move on to next block
	- impolementations in both bitcoin and ethereum is different
- other approaches also there like Proof of Stake and Proof of Elapsed Time
![Pasted image 20230212100912.png](./12.png)
## Robustness:
- how to manage exceptions satisfactorily?? Robustness
- exceptions that can occur in a blockchain:
	- more than 1 miner solving the consensus puzzle in close time frame
		- bitcoin allows chain split 
			- winner of the next cycle consolidates - that chain accepted
			- txns in the other blocks - returned to unconfirmed pool of txns
		- ethereum allows Omer / Runner-up blocks 
			- allocates small incentive to these blocks
			- helps keep the chain secure
			- new blocks only added to main chain not runner-up chains
			- runner-up blocks maintained for 6 more blocks 
			- block deeper in the chain is more trustworthy than the ones above it
	- more than 1 txn references the same digital asset (double spending)
		- in bitcoin allow first transaction that ref the digital asset and reject the rest 
		- in ethereum - combination of acc no and the global nonce is used
			- for every txn the global nonce is incremented
			- time stamp and the nonce should be unique and verified
- other exceptions may be - difficulty adjustment and hard and soft fork exception
## Forks:
- Soft Fork:
	- minor process adjustment carried out - boostrapping a new proc to the running processes
	- like a software patch/bug fix to address an issue
- Hard Fork:
	- major change in the protocol like a new version
	- after this the 2 chains are incompatible
- Add to the robustness of the framework
- Help to build credibility in the Blockchain
- Provide approaches to manage unexpected faults/planned improvements