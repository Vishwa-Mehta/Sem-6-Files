# Week 2 - Ethereum Blockchain 
## Smart Contracts:
- framework for execution of code was introduced by ethereum founders
- enables transactions that carry out more sophisticated operations
- like a class definition in an object oriented design
- has data, functions, access specifiers, getter and setters
- many languages to write smart contracats - ex Solidity
![Pasted image 20230126191138.pn](./7.png)
![7](https://user-images.githubusercontent.com/83157662/217571846-ce5262c2-731c-49c5-a730-b6db04a930f9.png)
- Parts of the code:
	- **pragma**: specifies version of solidity used
	- **contract**:  specifies the start of the contract
	- **uint**: data type unsigned int
	- **function**: for write and read of data 
- Exceution of code? -> computational infra? -> every node should be able to execute the code irrespective of the the underlying stuff like OS, H/W, etc. 
- Ethereum Virtual Machine (EVM): run anywhere abstraction
- High level prog lang -> EVM Byte Code -> deployed on the EVM
- smart contracts allow execution of code -> enhancing basic value transfer capability of blockchain

## Ethereum Structure:
- Ethereum introduced "accounts" in the txn -> originator and the target of a txn
- directly updates the acc balances instead of maintaining a "state" like in UTXOs
- transmit of values n messages n data that may result in state transitions -> implemented using txns
- accs are basic units of the ethereum protocol
- 2 types of accounts:
	- externally owned (EOA)
		- controlled by pvt keys
		- needed to participate in the network
		- interacts w/ chain using txns
	- contract (CA)
		- can be activated only by an EOA
		- represents a smart contract
		- every acc has coin balance
		- participant can send txn to send ether or invoke a smart contract
		- payed in **Wei**, 1 Ether = 10<sup>18</sup> Wei 
- txn ethereum has:
	- recepient of message
	- DS of the sender for authorisation
	- amt of wei to tranfer
	- optional payload with message to a contract
	- startgas - value repres the max no of computational steps for the txn
	- gasprice - sender fee for the computation
- ethereum block structure has:
	- header
	- txns
	- runner-up blk headers 
## Ethereum Operations:
- for a transfer - amt + trget addr + fees/gas points
- the fees are transfered to the accs
![Pasted image 20230126211114.png](./8.png)
![8](https://user-images.githubusercontent.com/83157662/217571917-34b76c0c-8065-4c79-b7e1-7564858c4827.png)
- eth node - computational sys representing the bussiness entity or the individual participant
- eth full node - hosts s/w for txn init, validation, etc...
- smart contract - designed, developed compiled, deployed on the EVM 
- more than one SC in and EVM
- execution code corresponding to the SC is activated and executed on the EVM - input extracted from the payload of the txn
- curr state of SC - values of the vars defined in it - state updated by this exec - result of exec stored in a receipt - blockchain maintains the state hash and the receipt hash
- all txns generated are validated
	- TS and Nonce combination is valid
	- sufficient fees are available for exec
- invoked SC code is executed by all miners
- validated txns are braodcast and gathered for block creation
- consensus protocol used - Memory based not CPU based PoW
## Incentive Model:
- gas related items in a txn:
	- every action requires crypto fuel/gas
	- gas points are used to specify the for ease of computation
	- gas points allow - independent valuation of txn fee and computation fee
	- ether varies as market prices change, gas points don't
- gas related items in a block:
	- gas limit - amt of gas points available 
	- gas spent - actual amt of gas spent at the completion of each block
- mining incentive model:
	- miner incentivised with the base fees of 3 eths + txn fee in blockchain + fees for execution of contract txns
	- miners who solve the puzzle but don't win - ommers - blocks created are called "ommer blocks" added as "side blocks" to the main chain
	- ommer miners also get a small % of total gas points as consolation and for n/w sec
- any transaction requires fees (transfer of ether included) to be specified in the txn